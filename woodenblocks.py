#cant explain in english so will do it in python

def find_hollow(blocks, index):
  n = len(blocks)
  if n == 1:
    return index[0]
  left = sum(blocks[:n / 2])
  right = sum(blocks[n / 2:])
  if left > right:
    return find_hollow(blocks[n / 2:], index[n / 2:])
  else:
    return find_hollow(blocks[:n / 2], index[:n / 2])

N = 8
blocks, index = [2, 2, 2, 2, 1, 2, 2, 2], range(N)
print find_hollow(blocks, index)
