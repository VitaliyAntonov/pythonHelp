export const checkWinning = gameArray => {
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