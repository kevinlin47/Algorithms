package main

import "fmt"

func main() {
	digits := "23"
	fmt.Println(letterCombinations(digits))
}

func search(list *[]string, str string, length int, digits string, dict map[byte][]byte) {
	if length == len(digits) {
		*list = append(*list, str)
		return
	}

	currentSet := dict[digits[length]]

	for _, c := range currentSet {
		search(list, str+""+string(c), length+1, digits, dict)
	}
}

func letterCombinations(digits string) []string {
	toReturn := []string{}

	dict := make(map[byte][]byte)
	dict['2'] = []byte{'a', 'b', 'c'}
	dict['3'] = []byte{'d', 'e', 'f'}
	dict['4'] = []byte{'g', 'h', 'i'}
	dict['5'] = []byte{'j', 'k', 'l'}
	dict['6'] = []byte{'m', 'n', 'o'}
	dict['7'] = []byte{'p', 'q', 'r', 's'}
	dict['8'] = []byte{'t', 'u', 'v'}
	dict['9'] = []byte{'w', 'x', 'y', 'z'}

	search(&toReturn, "", 0, digits, dict)

	return toReturn
}
