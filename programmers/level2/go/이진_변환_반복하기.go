package main

import (
	"strconv"
	"strings"
)

var cur string

func removeZeros() int {
	cnt := 0
	var sb strings.Builder

	arr := []rune(cur)
	for _, c := range arr {
		if c == '0' {
			cnt++
		} else {
			sb.WriteRune(c)
		}
	}

	cur = sb.String()
	return cnt
}

func binaryChange() int {
	len := len(cur)
	var arr []string

	for len > 0 {
		arr = append([]string{strconv.Itoa(len % 2)}, arr...)
		len /= 2
	}

	cur = strings.Join(arr, "")

	return 1
}

func 이진_변환_반복하기(s string) []int {
	cur = s

	zeroCnt := 0
	binaryCnt := 0

	for cur != "1" {
		// 0 제거
		zeroCnt += removeZeros()
		// 이진 변환
		binaryCnt += binaryChange()
	}

	return []int{binaryCnt, zeroCnt}
}
