interface CacheItem {
  value: number;
  timer: NodeJS.Timeout;
}

class TimeLimitedCache {
  
  private cache : Map<number,CacheItem>;

  constructor() {
      this.cache = new Map();
  }
  
  set(key: number, value: number, duration: number): boolean {
      const exists = this.cache.has(key);
      exists && clearTimeout(this.cache.get(key).timer);
      this.cache.set(key, {
          value,
          timer: setTimeout(() => this.cache.delete(key), duration)
      });
      return exists;
  }
  
  get(key: number): number {
      return this.cache.has(key) ? this.cache.get(key).value : -1;
  }
  
  count(): number {
      return this.cache.size;
  }
}

/**
* const timeLimitedCache = new TimeLimitedCache()
* timeLimitedCache.set(1, 42, 1000); // false
* timeLimitedCache.get(1) // 42
* timeLimitedCache.count() // 1
*/