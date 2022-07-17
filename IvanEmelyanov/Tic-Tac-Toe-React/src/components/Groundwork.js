import React, { useState, useEffect } from 'react';
import Gameboard from './Gameboard';
import Chooseplayer from './Chooseplayer';
import './Groundwork.css';
import { checkWinning, minimax } from '../funcbox';

function Groundwork() {
    const [gameArray, setGameArray] = useState(new Array(9).fill(null));
    const [startScreen, setStartScreen] = useState(true);
    const [players, setPlayers] = useState({ hu: 'X', ai: 'O' });
    const [nobodyWin, setNobodyWin] = useState(false);

    useEffect(() => {
        if (players.ai === 'X') {
            const tempGameArray = [...gameArray];

            const cellAi = minimax(
                tempGameArray,
                players.ai,
                players.hu,
                players.ai,
            ).index;
            tempGameArray[cellAi] = players.ai;

            setGameArray(tempGameArray);
        }
    }, [startScreen]);

    const playerTurn = cell => {
        const tempGameArray = [...gameArray];

        if (checkWinning(gameArray) || tempGameArray[cell]) {
            return;
        }

        tempGameArray[cell] = players.hu;
        const cellAi = minimax(
            tempGameArray,
            players.ai,
            players.hu,
            players.ai,
        ).index;
        tempGameArray[cellAi] = players.ai;

        if (!tempGameArray.includes(null)) {
            setNobodyWin(true);
        }

        setGameArray(tempGameArray);
    };

    const setAiValueX = () => {
        setPlayers({ hu: 'O', ai: 'X' });
    };

    const hideStartScreen = () => {
        setStartScreen(false);
    };

    const buttonClear = () => {
        setGameArray(new Array(9).fill(null));
        setStartScreen(true);
        setPlayers({ hu: 'X', ai: 'O' });
        setNobodyWin(false);
    };

    return (
        <div className='groundwork content-flex'>
            <Chooseplayer
                start={hideStartScreen}
                setaix={setAiValueX}
                status={startScreen}
            />
            <div className='winner-is content-flex'>
                {checkWinning(gameArray)
                    ? `The winner is: ${checkWinning(gameArray)[0]}`
                    : nobodyWin
                    ? 'Nobody Win'
                    : ''}
            </div>
            <Gameboard
                cells={gameArray}
                click={playerTurn}
                win={checkWinning(gameArray)}
            />
            <button className='btn-clear' onClick={buttonClear}>
                Начать заново
            </button>
        </div>
    );
}

export default Groundwork;
