const sodaMachine = (sodas) => {
    let lowestCount = Object.values(sodas)[0];
    for (const key in sodas) {
        if (sodas[key] < lowestCount) {
            lowestCount = sodas[key];
        }
    }
    return lowestCount;
};
console.log(sodaMachine({ pepsi: 10, coke: 5, sprite: 4, redbull: 9 }));
console.log(sodaMachine({ pepsi: 0, coke: 7, sprite: 9, redbull: 8 }));

const sumEvenOdd = (num) => {
    digits = num.toString();
    let sum = 0;
    for (let i = 0; i < digits.length; i++) {
        sum += Number(digits[i]);
    }
    return `The sum of the digits for ${num} is ${
        sum % 2 == 0 ? 'even' : 'odd'
    }`;
};
console.log(sumEvenOdd(1111));
console.log(sumEvenOdd(12345));

const countNestedWord = (string, phrase) => {
    let count = 0;
    let stringLower = string.toLowerCase();
    let phraseLower = phrase.toLowerCase();

    const recurNestedWord = (string, phrase) => {
        if (!string.includes(phrase)) {
            return count;
        } else if (string.includes(phrase)) {
            count++;
        }
        let index = string.indexOf(phrase);
        string = string.slice(index + phrase.length);
        return recurNestedWord(string, phrase);
    };
    count = recurNestedWord(stringLower, phraseLower);
    return count;
};
console.log(countNestedWord('nodejavascriptnodevscodejsnodejavascriptvscodenopenonenode', 'node'));
console.log(countNestedWord('There are many differences between Java and JavaScript', 'java'));

const cleanPhrase = (phrase) => {
    let phraseCleaned = phrase;
    for (let i = 0; i < phraseCleaned.length; i++) {
        if (!isNaN(phraseCleaned[i]) && phraseCleaned[i] !== ' ') {
            phraseCleaned =
                phraseCleaned.slice(0, i) + phraseCleaned.slice(i + 1);
            i--;
            continue;
        }
    }
    return phraseCleaned;
};
console.log(cleanPhrase('Th7e qu1ick br8own fo0x jum1ps over 22the la9zy d3og5.'));

const reverseAtWord = (arrIn, string) => {
    let index = arrIn.indexOf(string);
    const startHalf = arrIn.slice(0, index);
    const reverseHalf = arrIn.slice(index).reverse();
    const arrOut = [...startHalf, ...reverseHalf];
    return arrOut;
};
console.log(reverseAtWord(['alpha', 'beta', 'gamma', 'delta', 'epsilon'], 'gamma'));
console.log(reverseAtWord(['alpha', 'beta', 'gamma', 'delta', 'epsilon'], 'alpha'));

const ascendingArray = (arrIn) => {
    const arrayIn = arrIn;

    // Recursive base case
    if (arrayIn.length <= 1) {
        return arrayIn;
    }

    // Find value in center of array (rounded up)
    let pivotIndex = Math.round(arrayIn.length / 2);
    let pivotVal = arrayIn[pivotIndex];

    // Combine array without center pivot value
    const firstHalf = arrayIn.slice(0, pivotIndex);
    const secondHalf = arrayIn.slice(pivotIndex + 1);
    const arrNoPivot = [...firstHalf, ...secondHalf];

    let lessThanPivot = [];
    let gtrThanPivot = [];

    // Compare values in array against pivot
    // Add them into split arrays of less than or greater than
    for (let i = 0; i < arrNoPivot.length; i++) {
        if (arrNoPivot[i].length < pivotVal.length) {
            lessThanPivot.unshift(arrNoPivot[i]);
        } else {
            gtrThanPivot.push(arrNoPivot[i]);
        }
    }

    // Take split arrays and repreat comparisons until base case
    lessThanPivot = ascendingArray(lessThanPivot);
    gtrThanPivot = ascendingArray(gtrThanPivot);

    const combined = [];

    // Add values back from arrays in ascending order (including pivot)
    for (let j = 0; j < lessThanPivot.length; j++) {
        combined.push(lessThanPivot[j]);
    }
    combined.push(pivotVal);
    for (let k = 0; k < gtrThanPivot.length; k++) {
        combined.push(gtrThanPivot[k]);
    }
    return combined;
};
console.log(ascendingArray(['march', 'may', 'august', 'june']));
console.log(ascendingArray(['alpha', 'beta', 'gamma', 'delta', 'epsilon']));

const letterMap = (arrIn) => {
    const letters = {};
    const keys = [];
    const values = [];

    for (let i = 0; i < arrIn.length; i++) {
        keys.push(arrIn[i].toLowerCase());
        values.push(arrIn[i].toUpperCase());
    }

    keys.sort();
    values.sort();

    for (let j = 0; j < keys.length; j++) {
        let key = keys[j];
        let value = values[j];
        Object.assign(letters, { [key]: value });
    }
    return letters;
};
console.log(letterMap(['Z', 'a', 'b', 'y', 'x', 'c']));
