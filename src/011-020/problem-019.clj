;;ツェラーの公式で曜日を取得 
;;((year + (year/4) - (year/100) + (year/400) + ((13*month+8)/5) + day) % 7)
;;0なら日曜日,1なら月曜日... 6なら土曜日
(defn day-of-week [year month day]
  (let [year  (if (<= month 2)(dec year) year)
        month (if (<= month 2)(+ month 12) month)]
    (rem 
      (+ 
        (- (+ year (quot year 4))(quot year 100))
        (quot year 400)
        (quot (+ (* 13 month) 8) 5)
         day)
       7)))

(count (filter #(= 0 %)
  (for [year (range 1901 2001) month (range 1 13)](day-of-week year month 1))))