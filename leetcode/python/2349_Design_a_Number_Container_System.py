from queue import PriorityQueue

class NumberContainers:

    def __init__(self):
        self.idx: dict[int, int] = {}
        self.map: dict[int, PriorityQueue] = {}

    def change(self, index: int, number: int) -> None:
        self.idx[index] = number
        if number not in self.map:
            self.map[number] = PriorityQueue()
        self.map[number].put(index)
            

    def find(self, number: int) -> int:
        if number not in self.map:
            return -1
        
        pq = self.map[number]
        while not pq.empty():
            smallest_index = pq.queue[0]
            if self.idx.get(smallest_index) == number:
                return smallest_index
            pq.get()
        
        return -1

# Your NumberContainers object will be instantiated and called as such:
# obj = NumberContainers()
# obj.change(index,number)
# param_2 = obj.find(number)