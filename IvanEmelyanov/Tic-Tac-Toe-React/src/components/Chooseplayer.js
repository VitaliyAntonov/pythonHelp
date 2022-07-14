import React from 'react';
import './Chooseplayer.css';

function Chooseplayer(props) {
    let displayScreen;
    if (props.status) {
        displayScreen = 'choise-screen content-flex';
    } else {
        displayScreen = 'choise-screen content-flex choise-complit';
    }

    return (
        <div className={`${displayScreen}`}>
            <div className='black-screen'></div>
            <div className='choise-container'>
                <div className='choise-message'>Choose your<br/>player</div>
                <div className='choise-buttons-container content-flex'>
                    <div className='btn-choise content-flex' onClick={() => props.start('X')}>X</div>
                    <div className='btn-choise content-flex' onClick={() => props.start('O')}>O</div>
                </div>
            </div>
        </div>
    );
}

export default Chooseplayer;