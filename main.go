package main

import "fmt"

// Calculation reads the next integer in a test case
// and calculate the sum of squares
func calculation(numOfInt int) int {
	if numOfInt == 0 {
		return 0
	}

	var num int
	if numOfInt == 1 {
		fmt.Scanf("%d ", &num)
	} else {
		fmt.Scanf("%d", &num)
	}

	if num < 0 {
		return calculation(numOfInt - 1)
	} else {
		return calculation(numOfInt-1) + num*num
	}
}

// testCaseHandler reads number of integers in each test case
// and stores the results in an array
func testCaseHandler(numOfTestCases int, results []int) []int {
	if numOfTestCases == 0 {
		return results
	}

	var numOfInt int
	fmt.Scanf("%d ", &numOfInt)
	fmt.Println("integers: ", numOfInt)

	results[numOfTestCases] = calculation(numOfInt)
	return testCaseHandler(numOfTestCases-1, results)
}

func printResults(numOfTestCases int, results []int) {
	if numOfTestCases == 0 {
		return
	}

	fmt.Println(results[numOfTestCases])
	printResults(numOfTestCases-1, results)
}

func main() {
	var numOfTestCases int
	fmt.Scanf("%d ", &numOfTestCases)
	fmt.Println("test cases: ", numOfTestCases)
	results := make([]int, numOfTestCases+1)

	results = testCaseHandler(numOfTestCases, results)
	printResults(numOfTestCases, results)
}
