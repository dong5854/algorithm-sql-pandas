func kidsWithCandies(candies []int, extraCandies int) []bool {
	ans := make([]bool, 0, len(candies))
	for _, candy := range(candies) {
			givenExtra := candy + extraCandies
			temp := true
			for _, c := range (candies) {
					if givenExtra < c {
							temp = false
					}
			}
			ans = append(ans, temp)
	}
	return ans
}