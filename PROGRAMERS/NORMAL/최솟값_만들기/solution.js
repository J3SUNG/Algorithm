function solution(A,B){
    const size = A.length;
    let answer = 0;
    
    A.sort((a, b) => a - b);
    B.sort((a, b) => b - a);
    
    for(let i=0; i<size; ++i) {
        answer += A[i] * B[i];
    }

    return answer;
}