def update_dictionary(d, key, value):
  if d.get(key)!=None:
    d[key] = value
  d[2*key] = value