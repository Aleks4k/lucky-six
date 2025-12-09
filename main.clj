(require '[clojure.set :as set])

(defn valid-count? [coll]
  (= (count coll) 6))

(defn valid-range? [coll]
  (reduce (fn [_ x]
            (if (and (integer? x) (<= 1 x 48))
              true
              (reduced false)))
          true
          coll))

(defn has-duplicates? [coll]
  (let [result (reduce (fn [acc x]
                         (if (contains? acc x)
                           (reduced true)
                           (conj acc x)))
                       #{}
                       coll)]
    (if (true? result)
      true
      false)))

(defn lucky-six [x]
  (cond
    (not (valid-count? x))
    (println "Greška: moraš uneti tačno 6 brojeva!")

    (has-duplicates? x)
    (println "Greška: ne smeš unositi duplikate!")

    (not (valid-range? x))
    (println "Greška: svi brojevi moraju biti celi između 1 i 48!")

    :else
    (let [numbers (shuffle (range 1 49))
          draw (set (take 6 numbers))
          user-input (set x)
          hits (set/intersection draw user-input)]
      (println "Izvučeni brojevi:" draw)
      (println "Tvoji brojevi:" user-input)
      (println "Pogodaka:" (count hits))
      (println "Pogođeni brojevi:" hits))))

(lucky-six [3 7 11 22 35 46])