type Fn<T> = () => Promise<T>

function promiseAll<T>(functions: Fn<T>[]): Promise<T[]> {
    return new Promise<T[]>((resolve, reject) => {
        const res: T[] = new Array(functions.length).fill(null);
        let resolvedCount = 0;
        functions.forEach(async (el, idx) => {
            try {
                const subResult = await el();
                res[idx] = subResult;
                resolvedCount++;
                if (resolvedCount === functions.length) {
                    resolve(res);
                }
            } catch(err) {
            reject(err);
            }
        });
    });
};;

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */