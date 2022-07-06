import React, { useState } from 'react';
import Gameboard from './Gameboard';

function Groundwork() {
    const [gameArray, setGameArray] = useState(new Array(9).fill(null));
    const [currentMove, setCurrentMove] = useState(['X', 'O']);

    const checkWinning = () => {
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
                for (const elem of combination) {
                    document.getElementById(elem).style.color = '#a00';
                }
                return frst;
            }
        }
    };

    const playerTurn = cell => {
        const tempGameArray = [...gameArray];

        if (checkWinning() || tempGameArray[cell]) {
            return;
        }

        tempGameArray[cell] = currentMove[0];

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
            <div className="winner-is content-flex">{ checkWinning() ? `The winner is: ${checkWinning()}` : '' }</div>
            <Gameboard cells={gameArray} click={playerTurn} win={checkWinning()} />
            <button className="btn-clear" onClick={buttonClear}>Очистить поле</button>
        </div>
    );
}

export default Groundwork;