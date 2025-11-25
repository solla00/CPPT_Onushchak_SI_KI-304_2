
import os
import sys
import math
import struct


def writeResultTxt(fname, result):
    
    with open(fname, 'w') as f:
        f.write(str(result))


def readResultTxt(fname):
   
    result = 0.0
    try:
        if os.path.exists(fname):
            with open(fname, 'r') as f:
                result = float(f.read())
        else:
            raise FileNotFoundError(f"File {fname} not found.")
    except FileNotFoundError as e:
        print(e)
    return result


def writeResultBin(fname, result):
   
    with open(fname, 'wb') as f:
        f.write(struct.pack('f', result))


def readResultBin(fname):
  
    result = 0.0
    try:
        if os.path.exists(fname):
            with open(fname, 'rb') as f:
                result = struct.unpack('f', f.read())[0]
        else:
            raise FileNotFoundError(f"File {fname} not found.")
    except FileNotFoundError as e:
        print(e)
    return result




def calculate(x):
    
    return (7 * x) / math.tan(2 * x - 4)



if __name__ == "__main__":
    
    data = float(input("Enter x: "))
    
    
    result = calculate(data)
    
    
    print(f"Result is: {result}")
    
    try:
        
        writeResultTxt("textRes.txt", result)
        print(f"Result is: {readResultTxt('textRes.txt')}")
        
       
        writeResultBin("binRes.bin", result)
        print(f"Result is: {readResultBin('binRes.bin')}")
        
    except FileNotFoundError as e:
        print(e)