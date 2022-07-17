import React from 'react';
import PropTypes from 'prop-types';
import Cell from './Cell';
import './Gameboard.css';

function Gameboard({ cells, click, win }) {
    const addWinningScreen = () => <div className='gameboard content-flex winner-box'></div>;

    return (
        <div className='gameboard content-flex'>
            {cells.map((val, ind) => (
                <Cell key={ind} id={ind} value={val} cellclick={() => click(ind)} winarray={win} />
            ))}
            {win && addWinningScreen()}
        </div>
    );
}

Gameboard.propTypes = {
    cells: PropTypes.array,
    click: PropTypes.func,
    win: PropTypes.func,
};

export default Gameboard;
