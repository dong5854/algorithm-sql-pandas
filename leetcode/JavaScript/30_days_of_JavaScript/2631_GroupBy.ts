interface Array<T> {
  groupBy(fn: (item: T) => string): Record<string, T[]>
}

Array.prototype.groupBy = function(fn) {
  const grouped: Record<string,number[]> = {}
  this.forEach((e) => {
      const key = fn(e)
      grouped[key] ? grouped[key].push(e) : grouped[key] = [e];
  })
  return grouped
}

/**
* [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
*/