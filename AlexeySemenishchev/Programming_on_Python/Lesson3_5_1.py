import subprocess
with open("out.txt", "w") as ouf:
    subprocess.call(["python", "-h"], stdout=ouf)
