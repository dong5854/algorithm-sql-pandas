/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
let createCounter = function(init) {
  const origin = init
  return {
  increment: () => ++init,
  decrement: () => --init,
  reset: () => init = origin,
  }
};

/**
* const counter = createCounter(5)
* counter.increment(); // 6
* counter.reset(); // 5
* counter.decrement(); // 4
*/