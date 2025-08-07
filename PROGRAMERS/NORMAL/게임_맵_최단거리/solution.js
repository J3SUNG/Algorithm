class Queue {
    constructor() {
        this.q = [];
        this.i = 0;
    }
    
    push(v) { this.q.push(v); }    
    pop() { return this.q[this.i++]; }
    isEmpty() { return this.i === this.q.length; }
}

function solution(maps) {
    const h = maps.length, w = maps[0].length;
    const dy = [0, 1, 0, -1], dx = [1, 0, -1, 0];
    const q = new Queue();
    
    q.push([0, 0, 1]);
    maps[0][0] = 0;
    
    while(!q.isEmpty()) {
        const [y, x, d] = q.pop();
        if(y === h - 1 && x === w - 1) return d;

        for(let i=0; i<4; ++i) {
            const ny = y + dy[i], nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= h || nx >= w) continue;            
            if(maps[ny][nx] === 0) continue;
            
            maps[ny][nx] = 0;
            q.push([ny, nx, d + 1]);
        }
    }
    
    return -1;
}