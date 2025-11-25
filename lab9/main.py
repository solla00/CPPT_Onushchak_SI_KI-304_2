from Dictaphone import Dictaphone

if __name__ == "__main__":
    # Створюємо об'єкт класу Dictaphone
    dictaphone = Dictaphone("recording.mp3")

    
    dictaphone.record()           
    dictaphone.save_recording()   
    dictaphone.play()             
    dictaphone.stop()             