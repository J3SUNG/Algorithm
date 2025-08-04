const countOne = (n) => {
    let count = 0;
    while (n > 0) {
        count += n & 1;
        n >>>= 1;
    }
    return count;
};

function solution(n) {
    const one = countOne(n);
    let answer = n + 1;
    
    while (countOne(answer) !== one) {
        answer++;
    }

    return answer;
}