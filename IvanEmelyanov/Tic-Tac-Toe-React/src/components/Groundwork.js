import React, { useState } from 'react';
import Gameboard from './Gameboard';
import Chooseplayer from './Chooseplayer';
import './Groundwork.css';
import { checkWinning, minimax } from '../funcbox';

function Groundwork() {
    const [gameArray, setGameArray] = useState(new Array(9).fill(null));
    const [startScreen, setStartScreen] = useState(true);
    const [players, setPlayers] = useState({hu: 'X', ai: 'O'});
    const [nobodyWin, setNobodyWin] = useState(false);

    const whoFirst = choise => {
        setStartScreen(false);

        if (choise === 'O') {
            setPlayers({hu: 'O', ai: 'X'});
            aiTurn();
        }
    };

    const playerTurn = cell => {
        const tempGameArray = [...gameArray];

        if (checkWinning(gameArray) || tempGameArray[cell]) {
            return;
        }

        tempGameArray[cell] = players.hu;
        const cellAi = minimax(tempGameArray, players.ai, players.hu, players.ai).index;
        tempGameArray[cellAi] = players.ai;

        if (!tempGameArray.includes(null)) {
            setNobodyWin(true);
        }

        setGameArray(tempGameArray);
    };

    const aiTurn = () => {
        const tempGameArray = [...gameArray];

        const cellAi = minimax(tempGameArray, players.hu, players.ai, players.hu).index;
        tempGameArray[cellAi] = players.hu;

        setGameArray(tempGameArray);
    };

    const buttonClear = () => {
        setGameArray(new Array(9).fill(null));
        setStartScreen(true);
        setPlayers({hu: 'X', ai: 'O'});
        setNobodyWin(false);
    };

    return (
        <div className='groundwork content-flex'>
            <Chooseplayer start={whoFirst} status={startScreen} />
            <div className='winner-is content-flex'>{checkWinning(gameArray) ? `The winner is: ${checkWinning(gameArray)[0]}` : nobodyWin ? 'Nobody Win' : ''}</div>
            <Gameboard cells={gameArray} click={playerTurn} win={checkWinning(gameArray)} />
            <button className='btn-clear' onClick={buttonClear}>Начать заново</button>
        </div>
    );
}

export default Groundwork;