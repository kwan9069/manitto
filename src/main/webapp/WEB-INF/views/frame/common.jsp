<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<%-- JQuery --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
<script src="https://cdn.tailwindcss.com"></script>
<style type="text/tailwindcss">
    @tailwind base;
    @tailwind components;
    .input {
        @apply focus:outline-none focus:border-gray-500 p-3 border-2  text-lg border-gray-200 transition-colors;
    }
    .btn {
        @apply mt-3 text-lg font-medium text-2xl text-white p-4 bg-purple-300 hover:bg-purple-400 transition-colors rounded-2xl;
    }
    .layout {
        @apply mx-auto max-w-xl md:max-w-screen-2xl w-2/3 h-3/4;
    }
    .content-layout {
        @apply content-center justify-center pb-20;
    }
    .header {
        @apply flex items-center text-white h-40 content-center p-8;
    }
    .gradient-lane {
        @apply mx-auto max-w-xl md:max-w-screen-2xl w-1/2 bg-gradient-to-r from-purple-300 to-pink-200 h-32 p-8 ;
    }
    @tailwind utilities;
</style>