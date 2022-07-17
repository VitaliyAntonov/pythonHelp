import React from 'react';
import PropTypes from 'prop-types';
import './cell.css';

function Cell({ id, value, cellclick, winarray }) {
    return (
        <div
            className={`cell content-flex ${
                winarray ? winarray.includes(id) && 'winner-cell' : ''
            }`}
            id={id}
            onClick={cellclick}
        >
            {value}
        </div>
    );
}

Cell.propTypes = {
    id: PropTypes.number,
    value: PropTypes.number,
    cellclick: PropTypes.func,
    winarray: PropTypes.bool,
};

export default Cell;
