func mergeAlternately(word1 string, word2 string) string {
    ans := ""
    idx := 0
    for {
        if (idx >= len(word1) && idx >= len(word2)) {break}
        if (idx < len(word1)) {ans += string(word1[idx])}
        if (idx < len(word2)) {ans += string(word2[idx])}
        idx++;
    }
    return ans
}

func mergeAlternately(word1 string, word2 string) string {
    strSlice := make([]string, 0, len(word1) + len(word2))
    idx := 0
    for {
        if (idx >= len(word1) && idx >= len(word2)) {break}
        if (idx < len(word1)) {strSlice = append(strSlice, string(word1[idx]))}
        if (idx < len(word2)) {strSlice = append(strSlice, string(word2[idx]))}
        idx++;
    }
    return strings.Join(strSlice, "")
}

func mergeAlternately(word1 string, word2 string) string {
    var b bytes.Buffer
    idx := 0
    for {
        if (idx >= len(word1) && idx >= len(word2)) {break}
        if (idx < len(word1)) {b.WriteString(string(word1[idx]))}
        if (idx < len(word2)) {b.WriteString(string(word2[idx]))}
        idx++;
    }

    return b.String();
}