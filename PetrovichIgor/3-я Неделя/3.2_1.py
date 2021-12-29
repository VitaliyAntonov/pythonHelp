d = {}
def update_dictionary(d, key, value):
  #d, key, value = {}, 1, -1
  if d.get(key) != None:
    d[key] += [value]#; print(d)#; return
    return
  b=key*2
  if d.get(b) == None:
    d[b] = [value]#; print(d)
    return #d[key*2].append(value)
  d[b].append(value)#d[b] = [value]
  return

if __name__ == '__main__':
  print('PyCharm')
  print(update_dictionary(d, 1, -1))
  print(d)
  update_dictionary(d, 2, -2)
  print(d)
  update_dictionary(d, 1, -3)
  print(d)