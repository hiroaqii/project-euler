(defn hoge [x coll]
  (filter (fn [num](some #(zero? (rem num %)) coll))(range 1 x)))

;;1000未満の３か５の倍数の合計
(reduce + (hoge 1000 [3 5]))

;;1000000未満の4か7か13の倍数の合計
(reduce + (hoge 1000000 [4 7 13]))