function solution(s){
    let num = 0;
    
    for(const ch of s) {
        num += ch === "(" ? 1 : -1;
        
        if(num < 0) return false;
    }

    return num === 0;
}