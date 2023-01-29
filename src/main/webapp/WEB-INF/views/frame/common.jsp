<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<%-- JQuery --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
<link href="https://hangeul.pstatic.net/hangeul_static/css/NanumMiRaeNaMu.css" rel="stylesheet">
<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-myeongjo.css" rel="stylesheet">
<link href="https://hangeul.pstatic.net/hangeul_static/css/NanumNeuRisNeuRisCe.css" rel="stylesheet">
<script src="https://cdn.tailwindcss.com"></script>
<script>
    tailwind.config = {
        theme: {
            extend: {
                keyframes: {
                    'fade-in-down': {
                        '0%': {
                            opacity: '0',
                            transform: 'translateY(-10px)',
                        },
                        '100%': {
                            opacity: '1',
                            transform: 'translateY(0)',
                        },
                    },
                },
                animation: {
                    'fade-in-down': 'fade-in-down 0.5s ease-out',
                },
            },
        }
    }
</script>
<style type="text/tailwindcss">
    @tailwind base;
    @tailwind components;
    .input {
        @apply focus:outline-none focus:border-gray-500 p-3 border-2  text-lg border-gray-200 transition-colors;
    }
    .btn {
        @apply inline-block px-6 py-2.5 text-white font-medium text-xs leading-tight uppercase rounded shadow-md hover:bg-blue-700 hover:shadow-lg focus:shadow-lg focus:outline-none focus:ring-0 active:shadow-lg transition duration-150 ease-in-out w-full mb-3;
    }
    .normal-btn {
        @apply btn bg-purple-300 hover:bg-purple-400 w-full;
    }
    .layout {
        @apply mx-auto max-w-xl md:max-w-screen-2xl w-2/3 h-3/4;
    }
    .body-layout {
        @apply layout bg-bottom bg-no-repeat align-middle flex justify-center;
    }
    .content-layout {
        @apply content-center justify-center pb-20;
    }
    .header {
        @apply flex items-center text-white h-40 content-center p-8;
    }
    .footer {
        @apply mx-auto w-2/5 bg-gradient-to-r from-purple-300 to-pink-200 h-32;
    }
    @tailwind utilities;
</style>