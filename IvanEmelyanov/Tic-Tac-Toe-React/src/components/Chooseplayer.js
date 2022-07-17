import React from 'react';
import PropTypes from 'prop-types';
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
                <div className='choise-message'>
                    Choose your
                    <br />
                    player
                </div>
                <div className='choise-buttons-container content-flex'>
                    <div className='btn-choise content-flex' onClick={() => props.start()}>
                        X
                    </div>
                    <div
                        className='btn-choise content-flex'
                        onClick={() => {
                            props.start();
                            props.setaix();
                        }}
                    >
                        O
                    </div>
                </div>
            </div>
        </div>
    );
}

Chooseplayer.propTypes = {
    start: PropTypes.func,
    setaix: PropTypes.func,
    status: PropTypes.bool,
};

export default Chooseplayer;
