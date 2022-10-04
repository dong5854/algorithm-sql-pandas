"""
베스트앨범

https://school.programmers.co.kr/learn/courses/30/lessons/42579#
"""
def solution(genres, plays):
    album = {}
    # 장르별 분리
    for i, genre in enumerate(genres):
        if genre in album:
            album[genre].append((plays[i], i))
        else:
            album[genre] = [(plays[i], i)]
    
    # 장르별 곡의 재생수 정렬
    for i in album:
        album[i].sort(key = lambda x : (-x[0] , x[1]))
    
    # 장르별 재생수 합계 정렬
    genre_rank = {}
    for genre in album:
        genre_rank[genre] = 0
        for song in album[genre]:
            genre_rank[genre] += song[0]
    genre_rank = dict(sorted(genre_rank.items(), key=lambda x : x[1], reverse=True))
        
    
    # 최종 수록곡 담기
    answer = []
    for genre in genre_rank:
        if len(album[genre]) < 2:
            answer.append(album[genre][0][1])
        else:
            for i in range(2):
                answer.append(album[genre][i][1])
    
    return answer