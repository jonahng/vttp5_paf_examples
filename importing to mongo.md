Commands to import into mongo

mongoimport -dtvshows -cgames --type=json --jsonArray --file=C:\Users\65932\Downloads\bgg\game.json

for csv files, type=json and --headerline for header





THIS WORKED TO UPLOAD TO ATLAS:
mongoimport --uri mongodb+srv://paftest:paftest@cluster0.dj2cv.mongodb.net/test1 --collection test1 --type=json --jsonArray --file=C:\Users\65932\Downloads\bgg\comment.json

for railway, same command, but for uri must add /?authSource=admin at the back when importing!

test1 is the database name and collection name

TO ACCESS IN SPRING, application properties:
spring.data.mongodb.uri= mongodb+srv://paftest:paftest@cluster0.dj2cv.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0
spring.data.mongodb.database=database2



#example to connect to atlas:

#spring.data.mongodb.uri= mongodb+srv://<db_username>:<db_password>@cluster0.dj2cv.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0
#but since we do not want to include db username and password, remove everything up to cluster:

#spring.data.mongodb.uri=mongodb+srv://cluster0.dj2cv.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0
#input username and password separately
#spring.data.mongodb.username=username
#spring.data.mongodb.password=password
#spring.data.mongodb.database=boardgames
#IN SPRINGBOOT, you MUST say which database name


#in command prompt,
#mongosh 'mongodb+srv://cluster0.dj2cv.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0' --username=fred --password
