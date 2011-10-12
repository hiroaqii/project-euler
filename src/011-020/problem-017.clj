(def nums {1 "one", 2 "two", 3 "three", 4 "four", 5 "five", 
           6 "six", 7 "seven", 8 "eight", 9 "nine", 10 "ten",
           11 "eleven", 12 "twelve", 13 "thirteen", 14 "fourteen", 15 "fifteen", 
           16 "sixteen", 17 "seventeen", 18 "eighteen", 19 "nineteen", 20 "twenty",
           30 "thirty", 40 "forty", 50 "fifty", 60 "sixty", 70 "seventy", 80 "eighty", 90 "ninety"})

(defn num-to-word [x]
  (when (and (<= 1 x)(<= x 1000))
    (condp > x
      20  (nums x)
      100 (if (zero? (rem x 10))
             (nums (* (quot x 10) 10))
             (str (nums (* (quot x 10) 10)) " " (nums (rem x 10))))
      1000 (if (zero? (rem x 100))
             (str (nums (quot x 100)) " hundred")
             (str (nums (quot x 100)) " hundred and " (num-to-word (rem x 100))))
      "one thousand")))

(defn word-count [s]
  (count (apply str  (re-seq #"[\S]+" s))))

(reduce + (map word-count (map num-to-word (range 1 1001))))