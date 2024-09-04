type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type Obj = Record<string, JSONValue> | Array<JSONValue>;

function chunk(arr: Obj[], size: number): Obj[][] {
    const ret = []
    let s = 0;
    let e = s + size;
    while(s < arr.length) {
        ret.push(arr.slice(s, e));
        s += size;
        e += size;
    }
    return ret;
};
