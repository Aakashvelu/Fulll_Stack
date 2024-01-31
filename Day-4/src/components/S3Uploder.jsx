import AWS from "aws-sdk"
import { useState } from "react";
const S3Uploder = () =>{

    const [data,setData]= useState(null);
    
    const config = {
        bucketName: 'rockstart14k',
        dirName: 'user_files',
        region: 'ap-south-1',
        accessKeyId: 'AKIAQ3EGSCWSZP2ZUHRD',
        secretAccessKey: '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'
    }
    const handFileUpload = (event) => {
        // console.log(event.target.files[0]);
        const file=event.target.files[0];
        console.log(file);
        if(!config.bucketName || !config.region || !config.accessKeyId || !config.secretAccessKey){
            console.error("Aws configuration is complete");
            return;
        }

        //initializing our aws
        AWS.config.update({
            accessKeyId: config.accessKeyId,
            secretAccessKey: config.secretAccessKey,
            region: config.region
        })

        //creating new insatnce
        const S3=new AWS.S3();

        //HANING FILE IN ARRAY BUFFER
        const reader = new FileReader();

        reader.onload=()=>{
            const fileBuffer = reader.result
            S3.upload({
                Bucket: config.bucketName,
                Key: `${config.dirName}/${file.name}`,
                Body: fileBuffer,
                ACL: 'public-read',
                ContentType: 'image/jpg+xml'
            
            }, (err, uploadData) =>{
                if(err){
                    console.log(err);
                }
                else{   
                    setData(uploadData.Location);
                    console.log(uploadData);
                }

            })

        }
        reader.readAsArrayBuffer(file);
    };

    return(
        <div>
            <input type="file" onChange={handFileUpload}/>
            <img src={data} alt="uploaded Data" />
        </div>
    );
};
export default S3Uploder;