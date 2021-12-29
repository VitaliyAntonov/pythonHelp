if n == 0:
    v[n][i] += c[(len(c) - 1)][i]
elif n == len(c) - 1:
    v[n][i] += c[0][i]
else:
    v[n][i] += c[n - 1][i] + c[n + 1][i]
if i == 0:
    v[n][i] += c[n][len(c[0]) - 1]
elif i == len(c) - 1:
    v[n][i] += c[n][0]
else:
    v[n][i] += c[n][i - 1] + c[n][i + 1]