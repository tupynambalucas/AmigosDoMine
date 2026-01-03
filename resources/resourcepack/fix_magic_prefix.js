const fs = require('fs');
const path = require('path');

// Caminho para a pasta de assets relativo a este script
const targetDir = path.join(__dirname, 'src', 'main', 'assets');

console.log(`🔍 Iniciando varredura em: ${targetDir}`);

if (!fs.existsSync(targetDir)) {
    console.error(`❌ Erro: Diretório não encontrado em ${targetDir}`);
    process.exit(1);
}

let modifiedCount = 0;

function processFile(filePath) {
    try {
        const content = fs.readFileSync(filePath, 'utf8');
        
        // Verifica se o arquivo contém o prefixo antigo "magic:"
        // A Regex /magic:/g garante que todas as ocorrências sejam substituídas
        if (content.includes('magic:')) {
            const newContent = content.replace(/magic:/g, 'amigos:');
            fs.writeFileSync(filePath, newContent, 'utf8');
            console.log(`✅ Modificado: ${path.basename(filePath)}`);
            modifiedCount++;
        }
    } catch (err) {
        console.error(`❌ Erro ao processar ${filePath}:`, err);
    }
}

function walkDir(dir) {
    const files = fs.readdirSync(dir);
    files.forEach(file => {
        const fullPath = path.join(dir, file);
        const stat = fs.statSync(fullPath);
        
        if (stat.isDirectory()) {
            walkDir(fullPath);
        } else if (file.endsWith('.json')) {
            processFile(fullPath);
        }
    });
}

walkDir(targetDir);

console.log(`\n🎉 Concluído! Total de arquivos modificados: ${modifiedCount}`);
