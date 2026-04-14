# Tools-Api-java

API tools berbasis Java untuk mengelola dan mengintegrasikan berbagai layanan.

## 📋 Tentang Project

Project ini adalah REST API yang dibangun dengan Java, dirancang untuk memudahkan pengelolaan data dan integrasi dengan sistem lain. API ini mendukung operasi CRUD (Create, Read, Update, Delete) dan autentikasi dasar.

## 🚀 Fitur Utama

- **CRUD Operations** - Create, Read, Update, Delete data
- **JSON Response** - Output dalam format JSON
- **Request Validation** - Validasi input data
- **Error Handling** - Penanganan error yang informatif
- **Logging System** - Mencatat semua request dan response

## 🔧 Endpoint API

| Method | Endpoint | Deskripsi | Body Request |
|--------|----------|-----------|--------------|
| GET | `/api/tools` | Mendapatkan semua data tools | - |
| GET | `/api/tools/{id}` | Mendapatkan data tools by ID | - |
| POST | `/api/tools` | Menambahkan data tools baru | JSON |
| PUT | `/api/tools/{id}` | Mengupdate data tools | JSON |
| DELETE | `/api/tools/{id}` | Menghapus data tools | - |

## 📦 Contoh Request & Response

### 1. GET All Tools

**Request:**
```bash
GET http://localhost:8080/api/tools
