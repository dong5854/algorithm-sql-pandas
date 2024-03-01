package main

import "strings"

func solution(s string) string {
	var sb strings.Builder
	splitted := strings.Split(s, " ")
	for _, str := range splitted {
		if len(str) == 0 {
			sb.WriteString(" ")
		} else {
			sb.WriteString(strings.ToUpper(str[0:1]))
			sb.WriteString(strings.ToLower(str[1:len(str)]))
			sb.WriteString(" ")
		}
	}
	return sb.String()[0:len(s)]
}
