function isPalindrome(x: number): boolean {
  if (x < 0) return false;
  const c = x.toString()
  for (let i = 0; i < c.length/2; i++) {
      if (c[i] !== c[c.length-1-i]) return false;
  }
  return true;
};