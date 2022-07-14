// Функция проверки выигрыша
export const checkWinning = gameArray => {
    const winPack = [
        [0, 1, 2],
        [3, 4, 5],
        [6, 7, 8],
        [0, 3, 6],
        [1, 4, 7],
        [2, 5, 8],
        [0, 4, 8],
        [2, 4, 6]
    ];

    for (const combination of winPack) {
        const [i, j, k] = combination;
        const frst = gameArray[i];
        const scnd = gameArray[j];
        const thrd = gameArray[k];
        if (frst && frst === scnd && scnd === thrd) {
            return [frst, i, j, k];
        }
    }
};

// Функция Минимакс
export function minimax(newBoard, player, huPlayer, aiPlayer) {
    newBoard = newBoard.map((el, ind) => el === null ? ind : el);
    const availSpots = newBoard.filter(clr => clr !== "O" && clr !== "X");
    const checkWinTF = checkWinning(newBoard);

    if (checkWinTF && checkWinTF[0] === huPlayer) {
        return { score: -10 };
    }
    else if (checkWinTF && checkWinTF[0] === aiPlayer) {
        return { score: 10 };
    }
    else if (availSpots.length === 0) {
        return { score: 0 };
    }

    let moves = [];
    for (let i = 0; i < availSpots.length; i++) {
        const move = {};
        move.index = newBoard[availSpots[i]];

        newBoard[availSpots[i]] = player;

        if (player === aiPlayer) {
            const result = minimax(newBoard, huPlayer, huPlayer, aiPlayer);
            move.score = result.score;
        }
        else {
            const result = minimax(newBoard, aiPlayer, huPlayer, aiPlayer);
            move.score = result.score;
        }

        newBoard[availSpots[i]] = move.index;

        moves.push(move);
    }

    let bestMove;
    if (player === aiPlayer) {
        let bestScore = -Infinity;
        for (let i = 0; i < moves.length; i++) {
            if (moves[i].score > bestScore) {
                bestScore = moves[i].score;
                bestMove = i;
            }
        }
    } else {
        let bestScore = Infinity;
        for (let i = 0; i < moves.length; i++) {
            if (moves[i].score < bestScore) {
                bestScore = moves[i].score;
                bestMove = i;
            }
        }
    }

    return moves[bestMove];
}
