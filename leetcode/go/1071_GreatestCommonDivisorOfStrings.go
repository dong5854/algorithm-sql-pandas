func gcdOfStrings(str1 string, str2 string) string {
	minSize := len(str1)
	if minSize > len(str2) {
			minSize = len(str2)
	}

	ans := ""
	temp := ""
	for i := 0; i < minSize; i++ {
			able := true
			if (str1[i] == str2[i]) {
					temp += string(str1[i])
			}

			if (temp == "") {return ""}
			if (!isDividable(str1, temp) || !isDividable(str2, temp)) {able = false}

			if (able && len(temp) > 0 && len(str1) % len(temp) == 0 && len(str2) % len(temp) == 0) {
					ans = temp
			}
	}
	return ans
}

func isDividable(dividend string , divisor string) bool {
	able := true
	for idx, char := range dividend {
			divisorIdx := idx % len(divisor)
			if char != rune(divisor[divisorIdx]) {
					able = false
			}
	}
	return able
}

// 유클리드 호제법 사용
func gcdOfStrings(s1 string, s2 string) string {
	if s1 + s2 != s2 + s1 {
			return ""
	}
	x := gcd(len(s1), len(s2))
	return s1[:x]
}

func gcd(a, b int) int {
	for b != 0 {
			a, b = b, a % b
	}
	return a
}