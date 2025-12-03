(require '[clojure.set :as set])

(defn lucky-six [x]
  (let [numbers (shuffle (range 1 49)) ;(print (shuffle (range 1 49))) Uzimamo izmešane brojeve od 1 do 48 i ubacujemo u numbers.
        draw (set (take 6 numbers)) ;Uzimamo u draw 6 prvih elemenata iz numbers (ali to su nasumični jer smo gore radili shuffle).
        user-input (set x)] ;Pravimo set od korisničkog inputa.
    (let [hits (set/intersection draw user-input)]
      (println "Izvuceni brojevi:" draw)
      (println "Tvoji brojevi:" user-input)
      (println "Pogodaka:" (count hits))
      (println "Pogodjeni brojevi:" hits))))
(lucky-six [3 7 11 22 35 46]) ;Treba napraviti zaštitu od duplih ulaza?
