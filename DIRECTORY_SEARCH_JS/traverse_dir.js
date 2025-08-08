const { dir } = require("node:console");
const fs = require("node:fs");
const path = require("node:path");

function depthFirstSearchThroughDir(dir){
  const fileEntries = fs.readdirSync(dir);

  //Go through files in a dir.
  fileEntries.forEach(entry => {
    const fullFilePath = path.join(dir, entry)
    const isDir = fs.statSync(fullFilePath).isDirectory();

    const dirToSkip = [".git"];
    if(dirnameHas(fullFilePath, dirToSkip)) return;

    if(isDir){
      depthFirstSearchThroughDir(fullFilePath)
    }else{
      const  dirArray = path.dirname(fullFilePath).split(path.sep);
      const dirname = dirArray.at(-1);
      const filename = path.basename(fullFilePath);
      console.log("file: ", `${dirname}${path.sep}${filename}\n`);
    }
  })
}

function breadthFirstSearchThroughDir(dir){
  let queue = [dir];
  //pop first file entry.
  
  while(queue.length > 0){
    const file = queue[0];
    queue = queue.slice(1);
    const fileEntries = fs.readdirSync(file);
    fileEntries.forEach(entry => {
      const fullFilePath = path.join(file, entry);
      const isDir = fs.statSync(fullFilePath).isDirectory();

      const dirToSkip = [".git"];
      if(dirnameHas(fullFilePath, dirToSkip)) return;

      //If it is a directory add it to the queue to traverse later.
      if(isDir){
         queue.push(fullFilePath)
      }else{
        const  dirArray = path.dirname(fullFilePath).split(path.sep);
        const dirname = dirArray.at(-1);
        const filename = path.basename(fullFilePath);
        console.log("file: ", `${dirname}${path.sep}${filename}\n`);
      }
    })
  }
  
}

const root = "path/to/dir";


depthFirstSearchThroughDir(root);
breadthFirstSearchThroughDir(root);

function dirnameHas(filepath, dirCheckArray){
  const dirArray = filepath.split(path.sep);
  const lastDir = dirArray.at(-1);
  return dirCheckArray.includes(lastDir);
}


