import React, { useState } from 'react';
import Gameboard from './Gameboard';
import './Groundwork.css';
import { checkWinning } from '../funcbox';

function Groundwork() {
    const [gameArray, setGameArray] = useState(new Array(9).fill(null));
    const [currentMove, setCurrentMove] = useState(['X', 'O']);
    const [nobodyWin, setNobodyWin] = useState(false);

    const playerTurn = cell => {
        const tempGameArray = [...gameArray];

        if (checkWinning(gameArray) || tempGameArray[cell]) {
            return;
        }

        tempGameArray[cell] = currentMove[0];

        if (!tempGameArray.includes(null)) {
            setNobodyWin(true);
        }

        setGameArray(tempGameArray);
        setCurrentMove(currentMove.reverse());
    };

    const buttonClear = () => { 
        setGameArray(new Array(9).fill(null));
        setCurrentMove(['X', 'O']);

        gameArray.forEach((el, i) => document.getElementById(i).removeAttribute('style'));
    };

    return (
        <div className='groundwork content-flex'>
            <div className="winner-is content-flex">{ checkWinning(gameArray) ? `The winner is: ${checkWinning(gameArray)}` : nobodyWin ? 'Nobody Win' : '' }</div>
            <Gameboard cells={gameArray} click={playerTurn} win={checkWinning(gameArray)} />
            <button className="btn-clear" onClick={buttonClear}>Очистить поле</button>
        </div>
    );
}

export default Groundwork;