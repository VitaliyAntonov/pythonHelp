let cross_turn = true;
let fields_arr = [];
let fields_values_arr = [
  null, null, null,
  null, null, null,
  null, null, null
];
let turn_image = document.querySelector('.turn-image');
let field_heading_span_1 = document.querySelector('.field-heading').childNodes[0];
let field_heading_span_2 = document.querySelector('.field-heading').childNodes[1];
let cross_image = "url('./img/cross.svg') center center/cover";
let circle_image = "url('./img/circle.svg') center center/cover";
let strikethrough_line = document.querySelector('.strikethrough-line-container > div');


for (let i = 0; i < 9; i++) {
  fields_arr.push( document.querySelector(`.field${i}`) );
}

enableEventListeners();


function enableEventListeners() {

  enableMouseMoveListeners();
  enableClickListeners();
  enableButtonClickListener();
  
}

function enableMouseMoveListeners() {
  fields_arr.forEach( (field, field_index) => {

    let field_content = field.childNodes[0];

    field.onmouseover = mouse_event => {

      if (fields_values_arr[field_index] == null && cross_turn) {

        field_content.style.background = cross_image;
        field_content.style.opacity = '0.4';

      } else if (fields_values_arr[field_index] == null && !cross_turn) {

        field_content.style.background = circle_image;
        field_content.style.opacity = '0.4';

      } else if (fields_values_arr[field_index] != null) {

        field.style.background = '#ffd7d7';
      }
    };

    field.onmouseout = mouse_event => {

      if (fields_values_arr[field_index] == null) {

        field_content.style.background = "none";
        field_content.style.opacity = '1';

      } else {

        field.style.background = 'var(--bg-light)';
        field.style.opacity = '1';

      }
    };
  });
}

function enableClickListeners() {
  fields_arr.forEach( (field, field_index) => {

    let field_content = field.childNodes[0];

    field.onclick = () => {
      
      if (fields_values_arr[field_index] == null && cross_turn) {

        fields_values_arr[field_index] = 1;
        field_content.style.background = cross_image;
        field_content.style.opacity = '1';
        switchTurn();
        let game_result = getGameResult();
        if ( game_result[0] ) {
          showGameResults(game_result[0], game_result[1]);
        }

      } else if (fields_values_arr[field_index] == null && !cross_turn) {

        fields_values_arr[field_index] = 0;
        field_content.style.background = circle_image;
        field_content.style.opacity = '1';
        switchTurn();
        let game_result = getGameResult();
        if ( game_result[0] ) {
          showGameResults(game_result[0], game_result[1]);
        }
      }
    };
  });
}

function enableButtonClickListener() {
  let play_again_btn = document.querySelector('.play-again-btn');
  
  play_again_btn.onclick = () => {

    cross_turn = true;

    for (let i = 0; i < 9; i++) {
      fields_values_arr[i] = null;
    }

    enableMouseMoveListeners();
    enableClickListeners();
    updateFieldStyles();
  };
}

function switchTurn() {
  cross_turn = !cross_turn;
  turn_image.style.background = cross_turn ? cross_image : circle_image;
}

function getGameResult() {
  let lines_to_check = [
		[0, 1, 2],
		[3, 4, 5],
		[6, 7, 8],
		[0, 3, 6],
		[1, 4, 7],
		[2, 5, 8],
		[0, 4, 8],
		[2, 4, 6],
	];
  let result = [];

  lines_to_check.forEach( (line, line_index) => {
    let first_in_line = fields_values_arr[ line[0] ];

    if (first_in_line == null) return [];

    if (fields_values_arr[ line[1] ] == first_in_line && fields_values_arr[ line[2] ] == first_in_line) {
      result = first_in_line == 1 ? ['cross', line_index] : ['circle', line_index];
    }
  });

  if ( checkAllFieldsFilled() && !result[0] ) {
    result = ['draw'];
  }

  return result || [];
}

function checkAllFieldsFilled() {

  for (let i = 0; i < 9; i++) {
    if (fields_values_arr[i] == null) {
      return false;
    }
  }

  return true;
}

function showGameResults(game_result, winner_line) {

  showFinalMessage(game_result);
  showStrikethroughLine(game_result, winner_line);

}

function showFinalMessage(game_result) {
  fields_arr.forEach( (field, field_index) => {

    field.onmouseover = mouse_event => {};
    field.onclick = () => {};
  });

  turn_image.style.background = 'none';

  if (game_result == 'draw') {

    field_heading_span_2.textContent = 'ничья!';

  } else {

    field_heading_span_2.textContent = ' победили!';
  }

  if (game_result == 'cross') {

    field_heading_span_1.textContent = 'крестики';
    field_heading_span_1.style.color = 'var(--red)';

  } else if (game_result == 'circle') {

    field_heading_span_1.textContent = 'нолики';
    field_heading_span_1.style.color = 'var(--blue)';
  }
}

function showStrikethroughLine(game_result, winner_line) {
  if (game_result == 'draw') return;

  let line_width = 'var(--strikethrough-length)';
  let line_rotate = '0deg';
  let line_translate = 'translateX(0)';
  let line_color = 'var(--red)';

  if (game_result == 'circle') {
    line_color = 'var(--blue)'
  }

  if (winner_line >= 3 && winner_line <= 5) {
    line_rotate = '90deg';
  }

  if (winner_line == 6) {
    line_width = 'calc(var(--strikethrough-length) * 1.414)';
    line_rotate = '45deg';
  } else if (winner_line == 7) {
    line_width = 'calc(var(--strikethrough-length) * 1.414)';
    line_rotate = '135deg';
  }

  if (winner_line == 0 || winner_line == 2) {
    line_translate = 'translateY';
  } else if (winner_line == 3 || winner_line == 5) {
    line_translate = 'translateX';
  }

  if (winner_line == 0 || winner_line == 3) {
    line_translate += '(calc(0px - (var(--content-width) - var(--containers-padding) * 4) / 3) )';
  } else if (winner_line == 2 || winner_line == 5) {
    line_translate += '(calc((var(--content-width) - var(--containers-padding) * 4) / 3) )';
  }
  
  strikethrough_line.style.background = line_color;
  strikethrough_line.style.width = line_width;
  strikethrough_line.style.transform = `${line_translate} rotate(${line_rotate})`;
  strikethrough_line.style.display = 'block';
}

function updateFieldStyles() {

  field_heading_span_1.textContent = '';
  field_heading_span_2.textContent = 'ход:';
  turn_image.style.display = 'block';
  turn_image.style.background = cross_image;

  fields_arr.forEach( (field, field_index) => {
    let field_content = field.childNodes[0];
    field_content.style.background = 'none';
  });

  strikethrough_line.style.display = 'none';
}