import React from 'react';
import Cell from './Cell';
import './Gameboard.css';

function Gameboard({cells, click, win}) {
    const addWinningScreen = () => {
        return <div className='gameboard content-flex winner-box'></div>; 
    };

    return (
        <div className='gameboard content-flex'>
            { cells.map((val, ind) => <Cell key={ind} id={ind} value={val} cellclick={() => click(ind)} winarray={win} />) }
            { win && addWinningScreen() }
        </div>
    );
}

export default Gameboard;