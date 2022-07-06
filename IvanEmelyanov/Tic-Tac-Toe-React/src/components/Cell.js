import React from 'react';

function Cell({id, value, cellclick}) {
    return (
        <div className="cell content-flex" id={id} onClick={cellclick}>{value}</div>
    );
}

export default Cell;