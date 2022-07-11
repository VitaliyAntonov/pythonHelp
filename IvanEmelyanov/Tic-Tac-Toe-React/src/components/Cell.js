import React from 'react';
import './cell.css';

function Cell({id, value, cellclick, winarray}) {
    return (
        <div className={`cell content-flex ${winarray ? winarray.includes(id) && 'winner-cell' : ''}`} id={id} onClick={cellclick}>{value}</div> 
    );
}

export default Cell;