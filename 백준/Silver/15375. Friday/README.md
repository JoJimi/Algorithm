# [Silver V] Friday - 15375 

[문제 링크](https://www.acmicpc.net/problem/15375) 

### 성능 요약

메모리: 36524 KB, 시간: 692 ms

### 분류

수학, 구현

### 제출 일자

2026년 1월 30일 13:40:33

### 문제 설명

<ul>
	<li>December 21, 2012 - The predicted date for the end of the world is a Friday. This is when judgment day starts and a lot of things happen every Friday since this date.</li>
	<li>December 28, 2012 - Putin signs a law that bans Americans from adopting Russian children.</li>
	<li>January 4, 2013 - This day was filled with love. Hearts around the world were truly singing.</li>
	<li>January 11, 2013 - The world discovers confirmation bias.</li>
	<li>January 18, 2013 - An indecisive girl finally chooses to sit in the backseat. Aside from that, things were quite fun fun fun.</li>
	<li>January 25, 2013 - People around the world did not hesitate on this day, considering the day before didn’t even start.</li>
</ul>

<p>The list goes on! Weird things happen on Fridays after the 21st of December! You want to be prepared. You should make a schedule! You list down all Fridays (in chronological order) after the 21st of December. These are the days where you intend to wear a tinfoil hat to prevent things from happening to you.</p>

<p>Since you are very paranoid, you need to keep track if your list is correct. You don’t want to be unprotected during the dreaded Fridays of the future. You recall that leap years are those years divisible by 4, except those divisible by 100, but including those divisible by 400. You also assume that the universe will not end in 1018 days, and this rule about leap years will still be in place by then!</p>

<p>You also recall the order of the months. You can’t be too careful! Here is a list of the months (in order) and the number of days it has per year.</p>

<ul>
	<li>January (31)</li>
	<li>February (28. 29 during leap years.)</li>
	<li>March (31)</li>
	<li>April (30)</li>
	<li>May (31)</li>
	<li>June (30)</li>
	<li>July (31)</li>
	<li>August (31)</li>
	<li>September (30)</li>
	<li>October (31)</li>
	<li>November (30)</li>
	<li>December (31)</li>
</ul>

<p>And since you really want to make sure, you decide to make a program to check if you listed everything correctly!</p>

### 입력 

 <p>The first line of input contains T, the number of test cases. The following lines describe the test cases.</p>

<p>Each test case consists of a single line containing a single integer, N.</p>

<p>Constraints</p>

<ul>
	<li>1 ≤ T ≤ 50000</li>
	<li>1 ≤ N ≤ 10<sup>15</sup></li>
</ul>

### 출력 

 <p>For each test case, print which date must be the N th entry in the list.</p>

<p>The format must be “MMM DD, YYYY” (without quotes) where MMM is the name of the month (full month name and correctly capitalized, as in the above list and in the sample output), DD is the date and YYYY is the year (this may contain more than four digits).</p>

